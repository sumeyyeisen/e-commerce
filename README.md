# E-Ticaret Backend Projesi

Java Spring Boot ve MySQL ile ürün, sepet, sipariş ve stok takibi süreçlerini yöneten RESTful API projesi.

## Özellikler

- Ürün yönetimi (ekleme, güncelleme, silme, stok takibi)
- Sepet yönetimi (ürün ekleme, çıkarma, miktar güncelleme, toplam fiyat hesaplama)
- Sipariş yönetimi (sipariş oluşturma, geçmiş fiyat kaydı)
- Stok kontrolü (stok biten ürün sipariş edilemiyor)
- Müşteri yönetimi

## Teknolojiler

- Java 21
- Spring Boot
- MySQL
- Docker & Docker Compose
- Maven

## Çalıştırma

Docker ile tek komutla ayağa kaldır:
docker compose up

Uygulama http://localhost:8080 adresinde çalışır.

## Servisler

`AddCustomer` `GetProduct` `CreateProduct` `UpdateProduct` `DeleteProduct`  
`GetCart` `UpdateCart` `EmptyCart` `PlaceOrder` `GetOrderForCode`  
`GetAllOrdersForCustomer` `AddProductToCart` `RemoveProductFromCart`

## Kapsam ve Notlar

- Bu proje bir backend/API örneğidir. Kimlik doğrulama ve parola hash'leme (ör. BCrypt) kapsam dışıdır; üretim ortamında eklenmelidir.
- `docker-compose.yml` içindeki veritabanı parolası yerel geliştirme içindir.
