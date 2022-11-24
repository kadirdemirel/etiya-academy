/* Adres sorgusu */

select title, address, s.name, d.name, t.name, ci.name, co.name
from addresses a
         inner join streets s
                    on a.street_id = s.id
         inner join districts d
                    on s.district_id = d.id
         inner join towns t
                    on d.town_id = t.id
         inner join cities ci
                    on t.city_id = ci.id
         inner join countries co
                    on ci.country_id = co.id

/* Sipariş sorgusu */

select pt.name        as   "Ödeme Yöntemi",
       d.name         as   "Teslimat Seçeneği",
       i.number       as   "Fatura Numarası",
       i.created_date as   "Fatura Oluşturma Tarihi",
       pr.name        as   "Ürün Adı",
       pr.unit_price  as   "Ürün Fiyatı",
       pr.stock       as   "Ürün Stok Bilgisi",
       oi.quantity    as   "Ürün Adedi",
       oi.item_total_price as "Ürün Toplam Fiyatı",
       ad.title       as   "Adres Başlığı",
       ad.address     as   "Açık Adres",
       s.name         as   "Sokak",
       di.name         as   "Mahalle",
       t.name         as   "İlçe",
       ci.name        as   "Şehir",
       co.name        as   "Ülke"
from orders o
         inner join payments p
                    on o.id = p.id
         inner join payment_types pt
                    on p.payment_type_id = pt.id
         inner join invoices i
                    on o.id = i.id
         inner join delivery_options d
                    on o.delivery_options_id = d.id
         inner join order_items oi
                    on o.id = oi.order_id
         inner join products pr
                    on oi.product_id = pr.id
         inner join addresses ar
                    on o.order_address_id = ar.id
         inner join addresses ad
                    on o.invoice_address_id = ad.id
         inner join streets s
                    on ad.street_id = s.id
         inner join districts di
                    on s.district_id = di.id
         inner join towns t
                    on di.town_id = t.id
         inner join cities ci
                    on t.city_id = ci.id
         inner join countries co
                    on ci.country_id = co.id

/* Ürün Özellikleri Sorgusu */

select p.name        as "Ürün Adı",
       p.unit_price  as "Ürün Fiyatı",
       p.stock       as "Ürün Stok Bilgisi",
       p.description as "Açıklama",
       c.name        as "Kategori",
       pcv.name      as "Renk"
from product_categories pc
         inner join products p
                    on pc.product_id = p.id
         inner join categories c
                    on pc.category_id = c.id
         inner join product_details pd
                    on pd.product_id = p.id
         inner join product_chars pch
                    on pd.product_char_id = pch.id
         inner join product_char_values pcv
                    on pch.id = pcv.product_char_id