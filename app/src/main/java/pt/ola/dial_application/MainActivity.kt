package pt.ola.dial_application
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val items = listOf(
        Item("Aria Bennett", "+351 912 345 678"),
        Item("Ezra Whitmore", "+351 967 905 449"),
        Item("Kai Mercer", "+351 334 567 890"),
        Item("Lena Hartwell", "+351 395 265 332"),
        Item("Sofia Callahan", "+351 222 959 045")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = ItemAdapter(items)
        adapter.onItemClickListener = { item ->
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${item.phoneNumber}")
            startActivity(intent) }
        recyclerView.adapter = adapter
    }





}
