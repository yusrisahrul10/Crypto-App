# Crypto App
Aplikasi sederhana menampilkan list crypto

### App Libraries
* **Jetpack Navigation** - untuk navigasi antar fragment
* **Dagger-Hilt** - untuk Dependency Injection
* **Retrofit + RxJava** - untuk retrieve data dari API
* **Jetpack Pagination** - untuk implementasi load scroll
* **MVVM** - untuk design pattern
* **Data Binding** - untuk binding komponen XML
* **Junit** - untuk Unit Testing

### API
Api yang digunakan dalam project ini yaitu https://min-api.cryptocompare.com/data/

#### Endoint Used

|Method | Endpoint | Usage |
| ---- | ---- | --------------- |
|GET| `/top/totaltoptiervolfull` | Get a number of top coins by their total top tier volume based on the top 20 markets in the last 24 hours. |

### Parameters
| Parameter  | Argument | Description |
| ------------- | ------------- | ------------- |
| limit | INTEGER | The number of coins to return in the toplist, default 10, min 10, max 100 will round to steps of 10 coins [ Min - 10] [ Max - 100] [ Default - 10] |
| tsym | STRING | The currency symbol to convert into [ Min length - 1] [ Max length - 30] |