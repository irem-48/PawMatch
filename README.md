# 🐾 PawMatch

PawMatch, sahiplendirilmeyi bekleyen evcil hayvanları kullanıcılarla buluşturmak amacıyla geliştirilmiş bir Android mobil uygulamasıdır. Kullanıcılar uygulama üzerinden evcil hayvanları görüntüleyebilir, detaylarını inceleyebilir, favorilerine ekleyebilir ve sahiplendirme başvurusu yapabilirler.

Bu proje Manisa Celal Bayar Üniversitesi Yazılım Mühendisliği Bölümü kapsamında Mobil Uygulama Geliştirme dersi için geliştirilmiştir.

---

# 🎯 Proje Amacı

Evcil hayvan sahiplenme sürecini dijital ortama taşıyarak kullanıcıların kendilerine uygun dostları daha kolay bulabilmelerini sağlamak ve hayvan barınaklarının görünürlüğünü artırmaktır.

---

# 🚀 Uygulama Özellikleri

- Kullanıcı giriş ekranı
- Ana menü ve kategori sistemi
- Kedi ilanları görüntüleme
- Köpek ilanları görüntüleme
- Tüm hayvanları listeleme
- Evcil hayvan detay sayfası
- Favorilere ekleme sistemi
- Sahiplendirme başvuru formu
- Yakındaki barınakları görüntüleme
- Harita entegrasyonu
- API üzerinden dinamik görsel çekme

---

# 🛠 Kullanılan Teknolojiler

## Android Geliştirme

- Kotlin
- Android Studio
- XML Layout Tasarımı
- Android SDK

## Arayüz Tasarımı

- ConstraintLayout
- LinearLayout
- ScrollView
- Spinner
- Button
- EditText
- CheckBox
- TextView
- ImageView

## Veri Yönetimi

- SharedPreferences
- Intent Veri Aktarımı

## Ağ ve API İşlemleri

- Retrofit
- REST API
- JSON Veri İşleme

## Harita Entegrasyonu

- OpenStreetMap
- WebView

---

# 🏗 Uygulama Mimarisi

Uygulama çok sayfalı Android Activity mimarisi kullanılarak geliştirilmiştir.

### Activity Dosyaları

| Activity | Görevi |
|-----------|-----------|
| MainActivity | Kullanıcı giriş ekranı |
| HomeActivity | Ana menü |
| PetListActivity | Hayvan listeleme ekranı |
| PetDetailActivity | Hayvan detay ekranı |
| FavoritesActivity | Favoriler ekranı |
| AdoptionFormActivity | Sahiplendirme başvuru ekranı |
| SheltersMapActivity | Barınak haritası ekranı |

---

# 📂 Proje Yapısı

## Model Sınıfları

```text
Pet.kt
```

Evcil hayvan verilerini temsil eden model sınıfıdır.

## API Sınıfları

```text
RetrofitClient.kt
PetImageApiService.kt
CatImageResponse.kt
DogImageResponse.kt
```

Bu sınıflar internet üzerinden hayvan görsellerinin çekilmesini sağlar.

---

# 🐱 Örnek Evcil Hayvan Verileri

### Kediler

- Atlas (Manisa)
- Dali (İzmir)
- Uyku (Muğla)

### Köpekler

- Sherlock (Aydın)
- Watson (Denizli)

---

# 📍 Harita Özelliği

Uygulama içerisinde OpenStreetMap kullanılarak kullanıcıların yakınındaki hayvan barınakları görüntülenebilmektedir.

Harita ekranı WebView yardımıyla uygulama içerisinde gösterilmektedir.

---

# 📝 Sahiplendirme Sistemi

Başvuru formunda kullanıcıdan aşağıdaki bilgiler alınmaktadır:

- Ad Soyad
- Telefon Numarası
- Şehir
- Yaşam Alanı Türü
- Evcil Hayvan Deneyimi

Başvuru tamamlandığında kullanıcıya bilgilendirme mesajı gösterilmektedir.

---

# 📸 Uygulama Ekranları

- Giriş Ekranı
- Ana Menü
- Hayvan Listeleme Ekranı
- Detay Sayfası
- Favoriler Ekranı
- Sahiplendirme Formu
- Barınak Haritası

---

# 👩‍💻 Geliştirici

**İrem Nisa Sözen**  
**Öğrenci No:** 232803034

Manisa Celal Bayar Üniversitesi  
Yazılım Mühendisliği Bölümü

---

# 📚 Ders Bilgisi

**Ders:** Mobil Uygulama Geliştirme
