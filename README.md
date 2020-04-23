# IF2210- AvatarDuel

Aplikasi ini merupakan sebuah permainan duel kartu yang menerapkan gameplay mirip dengan perpaduan permainan Yu Gi Oh! dan Magic: The Gathering. Aplikasi ini bernama Avatarduel. Aplikasi ini diberinama Avatarduel karena karakter - karakter yang ada dalam permainan ini diambil dari anime Avatar.

Avatarduel dimainkan oleh dua orang pemain, yang berlaku sebagai pemain satu dan pemain dua. Pada awal permainan, pemain mempunyai nyawa sebanyak 80 dan mempunyai kartu di tangan. Ada 3 fase dalam game ini , yaitu fase draw card (mengambil satu kartu),  main fase (meletakkan kartu), dan fase battle (melakukan serangan). Tujuan dari game ini adalah menghabiskan nyawa musuh. Pemain yang berhasil menghabiskan nyawa musuh pertama kali adalah pemenangnya.

## Prerequisites

1. Java (Program ini dibuat menggunakan JDK-8 dan JRE 1.8.0)
2. JavaFX (Jika anda menggunakan Java versi 8, maka JavaFX sudah terinstall secara default)

### Installing

Saat menginstall java 8, gunakan perintah berikut
```
sudo apt update
apt install openjdk-8-jre-headless
```

### Running

```
./gradlew run
```
Yang terjadi saat eksekusi `./gradlew run` yaitu akan memanggil main fungsi dari aplikasi. Main fungsi dari aplikasi ini terdapat di  `AvatarDuel.java`.

Anda dapat mengeksplore gradle [disini](https://guides.gradle.org/creating-new-gradle-builds/)

### Look Documentation
Untuk dapat melihat dokumentasi stuktur kelas, jalankan command berikut
```
./gradlew avatarDocs
```
Hasil dari eksekusi tersebut menghasilkan file html yang dapat diakses di ./build/docs/javadoc/index.html.
Dokumentasi tersebut dibuat dengan [javadoc] (https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html).
### Testing

```
./gradlew test
```

## Screenshots
![Screenshot 1](/SS1.png)
![Screenshot 2](/SS2.png)

## Built With

* [Java](https://docs.oracle.com/en/java/) - Bahasa yang digunakan
* [JavaFX](https://docs.oracle.com/javase/8/javafx/api/toc.htm) - Dependency untuk olahan grafis

## Authors

* **Muhammad Zunan Alfikri** - *13518019* - [mzunanalfikri](https://github.com/mzunanalfikri)
* **Taufiq Husada Daryanto** - *13518058* - [taufiqhusada](https://github.com/taufiqhusada)
* **Rehan Adi Satrya** - *13518061* - [rehanadi30](https://github.com/rehanadi30)
* **Fadhil Muhammad Rafi’** - *13518079* - [fadhilrafiii](https://github.com/fadhilrafiii)
* **Fakhrurrida Clarendia Widodo** - *13518091* - [fakhrurrida](https://github.com/fakhrurrida)


## Acknowledgments

* Program ini dibuat untuk memenuhi kewajiban tugas besar 3 OOP

## Credit

All images and description are taken from [Avatar Wikia](https://avatar.fandom.com/wiki/Avatar_Wiki)
