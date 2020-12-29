package daniel.avila.ricknmortykmm.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import daniel.avila.ricknmortykmm.shared.Greeting
import android.widget.TextView
import daniel.avila.ricknmortykmm.shared.apiCharacterMapper
import daniel.avila.ricknmortykmm.shared.base.IBasePresenter
import daniel.avila.ricknmortykmm.shared.base.IBaseView
import daniel.avila.ricknmortykmm.shared.dataRemote
import daniel.avila.ricknmortykmm.shared.data_cache.CacheDataImp
import daniel.avila.ricknmortykmm.shared.data_cache.sqldelight.DatabaseDriverFactory
import daniel.avila.ricknmortykmm.shared.repository.RepositoryImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : BaseActivity() {
    override val presenter: IBasePresenter<in IBaseView>
        get() = TODO("Not yet implemented")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = Greeting().greeting()

//        val cacheData = CacheDataImp(DatabaseDriverFactory(this))
//
//        val repository = RepositoryImp(
//            cacheData = cacheData,
//            remoteData = dataRemote,
//            apiCharacterMapper = apiCharacterMapper
//        )
//
//        GlobalScope.launch(Dispatchers.Main) {
//            repository
//                .getCharacters()
//                .catch { throwable -> Log.d("aaa", "$throwable") }
//                .collect { characters ->
//                    Log.d("aaa", Thread.currentThread().name)
////                    tv.text = "Hola"
//                    characters.forEach { Log.d("aaa", "$it") }
//                }
//        }


//            val characters = withContext(Dispatchers.IO) {
//                try {
//                    repository.getCharacters()
//                } catch (e: Exception) {
//                    Log.d("aaa", "Error: $e")
//                }
//            }
////            characters.forEach {
////                Log.d("aaa", "$it")
////            }
//        }



    }
}
