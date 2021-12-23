package com.example.daycare.ui.parent.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                MainUI()
            }
        }
    }


}
@ExperimentalFoundationApi
@Composable
fun MainUI() {
    Column(modifier = Modifier.padding(12.dp)) {
        ProfileInfo()
        ParentActions()
    }
}

@Composable
fun ProfileInfo() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        // profile pic
        Image(
            painter = rememberImagePainter("https://miro.medium.com/max/1080/1*osc1NdwrqJjJuGR1XZsmlg.jpeg"),
            contentDescription = "profile pic",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        // user name
        Text(text = "Parent", modifier = Modifier.padding(start = 12.dp))
    }
}
@ExperimentalFoundationApi
@Composable
fun ParentActions(){
    LazyVerticalGrid(cells = GridCells.Fixed(2), modifier = Modifier.padding(top = 30.dp)) {

    }
}