//import com.example.smk_coding_tugas_2.GithubUserItem
import com.example.smk_coding_tugas_2.Scorer
import com.example.smk_coding_tugas_2.TopScorers
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ScorersService {

    @Headers("X-Auth-Token:f34cb5956c2640e1a7d5c315e943a7ea")
    @GET("v2/competitions/2021/scorers")
    fun getScorers(): Call<List<TopScorers>>

}