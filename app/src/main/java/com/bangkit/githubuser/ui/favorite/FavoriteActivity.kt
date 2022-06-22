package com.bangkit.githubuser.ui.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.githubuser.data.local.FavoriteUser
import com.bangkit.githubuser.data.model.User
import com.bangkit.githubuser.databinding.ActivityFavoriteBinding
import com.bangkit.githubuser.ui.detail.DetailUserActivity
import com.bangkit.githubuser.ui.main.UserAdapter

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        adapter = UserAdapter()
        adapter.notifyDataSetChanged()

        viewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)

        adapter.setOnItemClickCallback(object : UserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                Intent(this@FavoriteActivity, DetailUserActivity::class.java).also {
                    it.putExtra(DetailUserActivity.EXTRA_USERNAME, data.login)
                    it.putExtra(DetailUserActivity.EXTRA_ID, data.id)
                    it.putExtra(DetailUserActivity.EXTRA_HTML, data.html_url)
                    it.putExtra(DetailUserActivity.EXTRA_URL, data.avatar_url)
                    startActivity(it)
                }
            }
        })

        binding.apply {
            rvUser.setHasFixedSize(true)
            rvUser.layoutManager = LinearLayoutManager(this@FavoriteActivity)
            rvUser.adapter = adapter
        }

        viewModel.getFavoriteUser()?.observe(this) {
            if (it != null) {
                val list = mapList(it)
                adapter.setList(list)

            }
        }

    }

    private fun mapList(users: List<FavoriteUser>): ArrayList<User> {
        val listUsers = ArrayList<User>()
        for (user in users) {
            val userMapped = User(
                user.login,
                user.id,
                user.html_url,
                user.avatar_url
            )
            listUsers.add(userMapped)
        }
        return listUsers
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}