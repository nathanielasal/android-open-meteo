package dar.mobile.cuaca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FirstPage extends AppCompatActivity {

    private TextView tvTemp, tvWindSpeed, tvLatitude, tvLongtitude; //menampung hasil
    private TextView tvLocation, tvTodayWeather, tvSuhu, tvKecAngin, tvLat, tvLong;
    private TextView tvPrediction;
    private ImageView imgWeather;
    private RecyclerView rvWeather;
    private WeatherAdapter weatherAdapter;
    private List<Weather> cuaca = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        this.tvTemp = this.findViewById(R.id.tvTemp);
        this.tvWindSpeed = this.findViewById(R.id.tvWindSpeed);
        this.tvLatitude = this.findViewById(R.id.tvLatitude);
        this.tvLongtitude = this.findViewById(R.id.tvLongtitude);
        this.tvLocation = this.findViewById(R.id.tvLocation);
        this.tvTodayWeather = this.findViewById(R.id.tvTodayWeather);
        this.tvSuhu = this.findViewById(R.id.tvSuhu);
        this.tvKecAngin = this.findViewById(R.id.tvKecAngin);
        this.tvLat = this.findViewById(R.id.tvLat);
        this.tvLong = this.findViewById(R.id.tvLong);
        this.tvPrediction = this.findViewById(R.id.tvPrediction);

        this.imgWeather = this.findViewById(R.id.imgWeather);
        this.rvWeather = this.findViewById(R.id.rvWeather);

        // Menerima intent dari halaman sebelumnya
        Bundle dataVolley = getIntent().getExtras();
        int weathercode = dataVolley.getInt("weathercode");
        String temperature = dataVolley.getString("temperature");
        String windspeed = dataVolley.getString("windspeed");
        String latitude = dataVolley.getString("latitude");
        String longitude = dataVolley.getString("longitude");
        cuaca = (List<Weather>) dataVolley.getSerializable("cuaca");

        Bundle dataRetrofit = getIntent().getExtras();
        int RetrofitCode = dataRetrofit.getInt("code");
        String RetrofitTemp = dataRetrofit.getString("temperature");
        String RetrofitLatitude = dataRetrofit.getString("latitude");
        String RetrofitLongtitude = dataRetrofit.getString("longtitude");
        String RetrofitWindspeed = dataRetrofit.getString("windspeed");
        cuaca = (List<Weather>) dataRetrofit.getSerializable("cuaca");

        // Inisiasi cuaca
        Weather w = new Weather();
        if (dataVolley != null){
       // Set text
        tvTemp.setText(temperature);
        tvWindSpeed.setText(windspeed);
        tvLatitude.setText(latitude);
        tvLongtitude.setText(longitude);
        if (latitude.equals("-8.0") && longitude.equals("112.625")){
            tvLocation.setText("Malang");
        } else {
            tvLocation.setText("Lokasi");
        }}

        else if (dataRetrofit != null){
            w.setWeathercode(RetrofitCode);
            imgWeather.setImageResource(w.getGambar());
            tvTodayWeather.setText(w.getPrediction());
            tvTemp.setText(RetrofitTemp);
            tvWindSpeed.setText(RetrofitWindspeed);
            tvLatitude.setText(RetrofitLatitude);
            tvLongtitude.setText(RetrofitLongtitude);

        }
        w.setWeathercode(weathercode);
        imgWeather.setImageResource(w.getGambar());
        tvTodayWeather.setText(w.getPrediction());

        weatherAdapter = new WeatherAdapter(this, cuaca);
        rvWeather.setLayoutManager(new LinearLayoutManager(this));
        rvWeather.setAdapter(weatherAdapter);
    }
}