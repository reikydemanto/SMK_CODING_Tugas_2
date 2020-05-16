package data

import com.example.smk_coding_tugas_2.JadwalDonoDarahData
import retrofit2.Call
import retrofit2.http.GET
interface DonorService {
    @GET("exec?service=AKfycbxENZUqbOHUz7c7CevxlMJMkjxRMtP5rRim-SjFwcLSO9UDiBk&tanggal=05/16/2020&provinsi=Jawa+Timur")
//    fun getJadwalDonor(): Call<List<JadwalDonoDarahData>>
    fun getJadwalDonor(): Call<JadwalDonoDarahData>
}
