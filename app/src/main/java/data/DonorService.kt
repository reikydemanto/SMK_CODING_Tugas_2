package data

import com.example.smk_coding_tugas_2.dataclass.JadwalDonoDarahData
import com.example.smk_coding_tugas_2.dataclass.StokDarahData
import retrofit2.Call
import retrofit2.http.GET
interface DonorService {
    @GET("exec?service=AKfycbxENZUqbOHUz7c7CevxlMJMkjxRMtP5rRim-SjFwcLSO9UDiBk&tanggal=05/16/2020&provinsi=Jawa+Timur")
    fun getJadwalDonor(): Call<JadwalDonoDarahData>

    @GET("exec?service=AKfycbxENZUqbOHUz7c7CevxlMJMkjxRMtP5rRim-SjFwcLSO9UDiBk&gol=a_pos&produk=AHF&provinsi=Jawa+Timur")
    fun getStokDarah(): Call<StokDarahData>
}
