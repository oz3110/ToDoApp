package test.oz.todoapp.Activity.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import io.realm.Realm
import test.oz.todoapp.Activity.ToDoActivity
import test.oz.todoapp.R
import test.oz.todoapp.Realm.UserRealm

class LoadFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_load, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if( cacheLogin() ){
            startActivity( Intent(getActivity(), ToDoActivity::class.java))
            return
        }
        Navigation.findNavController(view).navigate(R.id.startFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun cacheLogin() : Boolean{
        val result = Realm.getDefaultInstance().where(UserRealm::class.java).findAll()
        // resultからパラメータ取得してログインする
        // 結果をリターンに入れて終了
        // ロード演出に関しては？
        return false
    }
}