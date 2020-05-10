import com.example.smk_coding_tugas_2.GithubUserItem
import retrofit2.Call
import retrofit2.http.GET
interface GithubService {
    @GET("users")
    fun getUsers(): Call<List<GithubUserItem>>
}