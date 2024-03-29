package uz.hamroev.medicaldiagnosis.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.hamroev.medicaldiagnosis.R
import uz.hamroev.medicaldiagnosis.adapter.AuthorAdapter
import uz.hamroev.medicaldiagnosis.cache.Cache
import uz.hamroev.medicaldiagnosis.databinding.FragmentAuthorBinding
import uz.hamroev.medicaldiagnosis.model.Author

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AuthorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AuthorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var binding: FragmentAuthorBinding
    lateinit var authorAdapter: AuthorAdapter
    lateinit var list: ArrayList<Author>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorBinding.inflate(layoutInflater, container, false)

       checkLanguage()
        authorAdapter = AuthorAdapter(binding.root.context, list)
        binding.rvAuthor.adapter = authorAdapter

        return binding.root
    }



    private fun checkLanguage() {
        when (Cache.til) {
            "ru" -> {
                loadRuData()
            }
            "krill" -> {
                loadKrillData()
            }
        }
    }

    private fun loadKrillData() {
        binding.appAbout.text =  "Sog'liqni Saqlashning Birlamchi Bo'g'ini Sharoitida Surunkali Yurak Yetishmovchiligi Kechishini Prognozlash va Buyrak Disfunksiyasini erta Tashxisining Algoritmi"
        list = ArrayList()
        list.clear()
        list.add(Author("Kamilova \nUmida \nKabirovna","m. f. d., professor, O'zbekiston Respublikasi Sog'liqni saqlash vazirligi Respublika ixtisoslashtirilgan terapiya va tibbiy reabilitatsiya ilmiy-amaliy tibbiyot markazi, ilmiy ishlar bo'yicha direktori",R.drawable.ic_umida))
        list.add(Author("Saida\nBeknazarova\nSafibullayevna","Professor\nt.f.d.\nMuhammad al-Xorazmiy nomidagi Toshkent Аxborot texnologiyalari universiteti Аudiovizual texnologiyalar kafedrasi professori", R.drawable.ic_saida))
        list.add(Author("Ataxodjaeva \nGulchehra \nAbdunabievna","t.f.d\nToshkent pediatriya tibbiyot instituti",R.drawable.ic_gulchehra))
        list.add(Author("Abdullaeva \n" + "Charos \n" + "Abdudjalilovna","T.f.d., dotsent Respublika ixtisoslashtirilgan terapiya va tibbiy reabilitasiya ilmiy-amaliy tibbiyot markazi", R.drawable.ic_charos))
        list.add(Author("Masharipova \n" + "Dilyafruz \n" + "Raxmatillaevna","Ilmiy kotib \"Respublika ixtisoslashtirilgan teraiya va tibbiy reabilitasiya ilmiy-amaliy tibbiyot markazi\" DM", R.drawable.ic_dilafruz))
        list.add(Author("Doston\nHamroyev\nDavron o'g'li","Android Dasturchi\n\nMuhammad al-Xorazmiy nomidagi Toshkent Аxborot texnologiyalari universiteti Televizion Texnologiyalari fakulteti talabasi", R.drawable.ic_doston))
    }

    private fun loadRuData() {
        binding.appAbout.text = "Алгоритм ранней диагностики дисфункции почек и прогнозирования течения хронической сердечной недостаточности  в условиях первичного звена здравоохранения"
        list = ArrayList()
        list.clear()
        list.add(Author("Камилова \nУмида \nКабировна","д.м.н., профессор, директор по научной работе Республиканского специализированного научно-практического медицинского центра терапии и медицинской реабилитации Министерства Здравоохранения Республики Узбекистан",R.drawable.ic_umida))
        list.add(Author("Бекназарова \nСаида \n" + "Сафибуллаевна","Профессор\nд.т.н.\nПрофессор кафедры аудиовизуальные технологии Ташкентского университета информационных технологий имени Мухаммада ал-Хорезми", R.drawable.ic_saida))
        list.add(Author("Атаходжаева \nГулчехра \nАбдунабиевна","д.м.н.\nТашкентский педиатрический медицинский институт",R.drawable.ic_gulchehra))
        list.add(Author("Абдуллаева \nЧарос \nАбдуджалиловна","Д.м.н., доцент Республиканского специализированного научно-практического медицинского центра терапии и медицинской реабилитации\" ", R.drawable.ic_charos))
        list.add(Author("Машарипова \nДиляфруз \nРахматиллаевна","Ученый секретарь, \n" + "ГУ \"Республиканский специализированный научно-практический медицинский центр терапии и медицинской реабилитации\"", R.drawable.ic_dilafruz))
        list.add(Author("Достон \nҲамроев \nДавронович","Андроид разработчик\n\nСтудент Факультет Телевизионных технологий Ташкентского университета информационных технологий имени Мухаммада ал-Хорезми", R.drawable.ic_doston))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AuthorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AuthorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}