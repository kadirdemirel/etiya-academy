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

/* 2- Sipariş sorgusu */

select pt.name             as "Ödeme Yöntemi",
       d.name              as "Teslimat Seçeneği",
       i.number            as "Fatura Numarası",
       i.created_date      as "Fatura Oluşturma Tarihi",
       pr.name             as "Ürün Adı",
       pr.unit_price       as "Ürün Fiyatı",
       pr.stock            as "Ürün Stok Bilgisi",
       oi.quantity         as "Ürün Adedi",
       oi.item_total_price as "Ürün Toplam Fiyatı",
       ad.title            as "Adres Başlığı",
       ad.address          as "Açık Adres",
       s.name              as "Sokak",
       di.name             as "Mahalle",
       t.name              as "İlçe",
       ci.name             as "Şehir",
       co.name             as "Ülke"
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

/* 3- Ürün Özellikleri Sorgusu */

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

/* 4- Bireysel Müşteriler Sorgusu */
select ic.first_name,
       ic.last_name,
       ic.identity_number,
       cu.number,
       us.email,
       us.password
from individual_customers ic
         inner join customers cu
                    on ic.id = cu.id
         inner join users us
                    on cu.id = us.id

/* 5- Müşterilerin İsmine Göre Sorgu */
select ic.first_name, ic.last_name, ic.identity_number, cu.number, us.email, us.password
from individual_customers ic
         inner join customers cu
                    on ic.id = cu.id
         inner join users us
                    on cu.id = us.id
where ic.first_name = 'Onur'

/* 6- Ödeme yapan kişilerden adı Emre olan ve Ödeme Yöntemi Kredi Kartı Olan Sorgular */
select ic.first_name, ic.last_name, pt.name
from payments py
         inner join payment_types pt
                    on py.payment_type_id = pt.id
         inner join orders od
                    on py.id = od.id
         inner join addresses ad
                    on od.invoice_address_id = ad.id
         inner join users us
                    on ad.user_id = us.id
         inner join customers cu
                    on us.id = cu.id
         inner join individual_customers ic
                    on cu.id = ic.id
where ic.first_name = 'Emre'
  and pt.name = 'Kredi Kartı'

/* 7- İstanbul'dan sipariş veren müşteri listesi */
select ic.first_name, ic.last_name, ci.name
from orders od
         inner join payments py
                    on od.id = py.id
         inner join addresses ad
                    on od.invoice_address_id = ad.id
         inner join users us
                    on ad.user_id = us.id
         inner join customers cu
                    on us.id = cu.id
         inner join individual_customers ic
                    on cu.id = ic.id
         inner join streets st
                    on ad.street_id = st.id
         inner join districts di
                    on st.district_id = di.id
         inner join towns tw
                    on di.town_id = tw.id
         inner join cities ci
                    on tw.city_id = ci.id
where ci.name = 'İstanbul'
  and py.is_verified = true

/* 8- Siparişlerden teslimat seçeneği "Adrese teslim" olan müşteri listesi */
select ic.first_name, ic.last_name, de.name
from orders od
         inner join delivery_options de
                    on od.delivery_options_id = de.id
         inner join addresses ad
                    on od.invoice_address_id = ad.id
         inner join users us
                    on ad.user_id = us.id
         inner join customers cu
                    on us.id = cu.id
         inner join individual_customers ic
                    on cu.id = ic.id
where de.name = 'Adrese teslim'

/* 9- Giyim kategorisindeki ürünler listesi */
select pr.name
from products pr
         inner join product_categories pc
                    on pr.id = pc.product_id
         inner join categories ca
                    on ca.id = pc.category_id
where ca.id = 3

/* 10- Sepetteki en yüksek ücretli ürün  */
select max(pr.unit_price), pr.name
from baskets ba
         inner join basket_items bi
                    on ba.id = bi.basket_id
         inner join products pr
                    on bi.product_id = pr.id
group by pr.name

-- İstanbul ve Ankara'da yaşayan müşterileri listeleyin

select ci.name as "Şehir", ic.first_name, ic.last_name
from individual_customers ic
         inner join customers c
                    on ic.id = c.id
         inner join users us
                    on c.id = us.id
         inner join addresses ad
                    on ad.user_id = us.id
         inner join streets st
                    on ad.street_id = st.id
         inner join districts di
                    on st.district_id = di.id
         inner join towns t
                    on di.town_id = t.id
         inner join cities ci
                    on t.city_id = ci.id
where ci.name in ('Ankara', 'İstanbul')

-- 50 TL ve 200 TL arasında bulunan ürünlerin adları ve fiyatlarını listeleyiniz
select name, unit_price
from products
where unit_price between 50 and 200

-- Hangi şehirden kaç müşteri var?
select ci.name as "Şehir", count(*) "Müşteri Sayısı"
from cities ci
         inner join towns tw
                    on ci.id = tw.city_id
         inner join districts di
                    on tw.id = di.town_id
         inner join streets st
                    on di.id = st.district_id
         inner join addresses ad
                    on st.id = ad.street_id
         inner join users us
                    on us.id = ad.user_id
         inner join customers cu
                    on us.id = cu.id
group by ci.name

-- Siparişlerin ortalama fiyatı
select avg(total_price)
from orders

-- Ürün fiyatı güncelleme
update products
set unit_price = 18000
where name = 'Hp Laptop'

-- Insert işlemi
    insert
into delivery_options(name)
values ('Teslimat Noktası')
select *
from delivery_options

-- Delete işlemi
delete
from delivery_options
where name = 'İş Yeri'

-- Hangi ürün hangi kategoride
select p.name, c.name
from product_categories pc
         inner join products p
                    on pc.product_id = p.id
         inner join categories c
                    on pc.category_id = c.id
group by p.name, c.name

-- Şehir sıralaması
Select name
from cities
where name between 'A' and 'E'
order by name

-- Sepetler içindeki kargo ücretleri toplamı
select sum(shipping_price)
from baskets