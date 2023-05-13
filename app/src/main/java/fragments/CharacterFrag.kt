package fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Intents
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uts_botnavrecview.*


class CharacterFrag : Fragment() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: CharactersAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var charArrayList: ArrayList<Characters>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvChar)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CharactersAdapter(charArrayList){
        val intent = Intent(context,DetailCharacterActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        charArrayList = arrayListOf<Characters>()

        image = arrayOf(
            R.drawable.belimbing,
            R.drawable.jambubiji,
            R.drawable.mangga,
            R.drawable.manggis,
            R.drawable.nanas,
            R.drawable.pepaya,
            R.drawable.rambutan,
            R.drawable.salak,
            R.drawable.sawo,
            R.drawable.sirsak,
        )

        title = arrayOf(
            getString(R.string.belimbing),
            getString(R.string.jambubiji),
            getString(R.string.mangga),
            getString(R.string.manggis),
            getString(R.string.nanas),
            getString(R.string.pepaya),
            getString(R.string.rambutan),
            getString(R.string.salak),
            getString(R.string.sawo),
            getString(R.string.sirsak),

        )
        description = arrayOf(
            getString(R.string.desc_belimbing),
            getString(R.string.desc_jambubiji),
            getString(R.string.desc_mangga),
            getString(R.string.desc_manggis),
            getString(R.string.desc_nanas),
            getString(R.string.desc_pepaya),
            getString(R.string.desc_rambutan),
            getString(R.string.desc_salak),
            getString(R.string.desc_sawo),
            getString(R.string.desc_sirsak),
        )

        for (i in image.indices) {
            val char = Characters(image[i], title[i], description[i])
            charArrayList.add(char)
        }

    }
}
