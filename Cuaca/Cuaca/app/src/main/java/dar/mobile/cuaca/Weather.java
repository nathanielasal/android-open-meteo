package dar.mobile.cuaca;

import java.io.Serializable;

public class Weather implements Serializable {

    private int gambar, weathercode;
    private String tanggal, prediction;

    public Weather(){}
    public Weather(int weathercode, String tanggal){
        this.weathercode = weathercode;
        this.tanggal = tanggal;
    }

    public String getTanggal(){
        return tanggal;
    }

    public void setWeathercode(int weathercode){
        this.weathercode = weathercode;
    }

    public int getWeathercode(){
        return weathercode;
    }

    public String getPrediction(){
        switch (weathercode){
            case 0:
                this.prediction = "Clear Sky";
                break;
            case 1:
                this.prediction = "Mainly Clear";
                break;
            case 2:
                this.prediction = "Partly Cloudy";
                break;
            case 3:
                this.prediction = "Overcast";
                break;
            case 45:
                this.prediction = "Fog";
                break;
            case 48:
                this.prediction = "Depositing Rime Fog";
                break;
            case 51:
                this.prediction = "Drizzle: Light";
                break;
            case 53:
                this.prediction = "Drizzle: Moderate";
                break;
            case 55:
                this.prediction = "Drizzle: Dense";
                break;
            case 56:
                this.prediction = "Freezing Drizzle: Light";
                break;
            case 57:
                this.prediction = "Freezing Drizzle: Dense";
                break;
            case 61:
                this.prediction = "Rain: Slight";
                break;
            case 63:
                this.prediction = "Rain: Moderate";
                break;
            case 65:
                this.prediction = "Rain: Heavy";
                break;
            case 66:
                this.prediction = "Freezing Rain: Slight";
                break;
            case 67:
                this.prediction = "Freezing Rain: Heavy";
                break;
            case 71:
                this.prediction = "Snow Fall: Slight";
                break;
            case 73:
                this.prediction = "Snow Fall: Moderate";
                break;
            case 75:
                this.prediction = "Snow Fall: Heavy";
                break;
            case 77:
                this.prediction = "Snow Grains";
                break;
            case 80:
                this.prediction = "Rain Showers: Slight";
                break;
            case 81:
                this.prediction = "Rain Showers: Moderate";
                break;
            case 82:
                this.prediction = "Rain Showers: Violent";
                break;
            case 85:
                this.prediction = "Snow Showers: Slight";
                break;
            case 86:
                this.prediction = "Snow Showers: Heavy";
                break;
        }
        return prediction;
    }

    public int getGambar(){
        switch (weathercode){
            case 0:
                this.gambar = R.drawable.clears_sky;
                break;
            case 1: case 2:
                this.gambar = R.drawable.partly_cloudy;
                break;
            case 3:
                this.gambar = R.drawable.overcast;
                break;
            case 45: case 48:
                this.gambar = R.drawable.fog;
                break;
            case 51: case 53: case 55:
                this.gambar = R.drawable.drizzle;
                break;
            case 56: case 57:
                this.gambar = R.drawable.freezing_drizzle;
                break;
            case 61: case 63: case 65:
                this.gambar = R.drawable.rain;
                break;
            case 66: case 67:
                this.gambar = R.drawable.freezing_rain;
                break;
            case 71: case 73: case 75:
                this.gambar = R.drawable.snow_fall;
                break;
            case 77:
                this.gambar = R.drawable.snow_grains;
                break;
            case 80: case 81: case 82:
                this.gambar = R.drawable.rain_shower;
                break;
            case 85: case 86:
                this.gambar = R.drawable.snow_shower;
                break;
            default:
                break;
        }
        return gambar;
    }
}
