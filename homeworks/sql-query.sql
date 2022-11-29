-- Bugünün tarihini almak
select CURRENT_DATE as "Bugünün Tarihi"
--
select * from invoices
select * from individual_customers
-- date_part
select date_part('month', CURRENT_DATE) as "İçinde Bulunulan Ay"
select date_part('year', CURRENT_DATE) as "İçinde Bulunulan Yıl"
select date_part('century', CURRENT_DATE) as "İçinde Bulunulan Yüzyıl"
select date_part('day', CURRENT_DATE) as "İçinde Bulunulan Gün"

select id, date_part('month', created_date) from invoices

-- Ayın 28. günü verilen sipariş faturaları
select * from invoices
where date_part('day', created_date) = 28

-- Son 10 gün içindeki faturalar
select * from invoices where (date_part('year', current_date) = date_part('year', created_date))
and (date_part('month', current_date) = date_part('month', created_date))
and (date_part('day', current_date) - (date_part('day', created_date))) <= 10

select * from users where (date_part('year',current_date) - (date_part('year', birth_date))) > 21

-- extract 
select extract(month from current_date) as "İçinde Bulunulan Ay"
select date_part('month', CURRENT_DATE) as "İçinde Bulunulan Ay"
--Yukarıdaki ikili aynı sonucu verir
select extract(year from created_date), count(*) from invoices
group by extract(year from created_date)

-- datediff => postgresql mevcut değil
-- timestamp
-- type conversion

-- timestamp ile çevrilmiş durumda çıktı türü interval'dir, numeric işlem yapılamaz. 
-- Bu yüzden date_part içine alarak çıktıyı numeric hale getiriyoruz

-- Son 3 gün içindeki faturalar
select * from invoices
where (date_part('days', current_date::timestamp-created_date::timestamp)) <= 3 

-- Hafta sonucu elde etme, TRUNC fonksiyonu ile haftayı tam sayı olarak elde ediyoruz
select TRUNC(date_part('days', current_date::timestamp-created_date::timestamp) / 7) from invoices

-- İki tarih arasındaki saat farkını almak
select DATE_PART('hour', '2022-11-28 21:00'::timestamp) as "Tarih"
select DATE_PART('hour', '2022-11-29 16:00'::timestamp) as "Tarih"

-- İlgili query'i saat farkını doğru bir şekilde verecek hale getiriniz
select DATE_PART('day', '2022-11-29 22:00'::timestamp - '2022-11-28 21:00'::timestamp) * 24 +
DATE_PART('hour', '2022-11-29 22:00'::timestamp - '2022-11-28 21:00'::timestamp)
as "Saat Farkı"

-- 1-) 2000 den önce doğanları gösteren sorgu
select first_name,last_name,birth_date from  individual_customers
where (date_part('year', birth_date))<2000

-- 2-) kullanıcıların yaşını getiren sorgu
select first_name,last_name, (date_part('year',current_date) - (date_part('year', birth_date)))
as "Yaş" from  individual_customers 

-- 3-) kullanıcıların yaşlarına göre sıralayan sorgu
select first_name,last_name, (date_part('year',current_date) - (date_part('year', birth_date)))
as "Yaş" from  individual_customers order by birth_date desc

-- 4-) Yaşı 23'den büyük olan müşterileri getiren sorgu
select first_name,last_name, (date_part('year',current_date) - (date_part('year', birth_date)))
as "Yaş" from  individual_customers
where (date_part('year',current_date) - (date_part('year', birth_date)))>23

-- 5-) Son bir yıl içerisindeki siparişleri getiren sorgu
SELECT * FROM orders
where   (date_part('year', order_date)) > (date_part('year',current_date)-1)

-- 6-) Son 30 gün içindeki faturaları getiren sorgu 
select * from invoices where (date_part('days', current_date::timestamp-created_date::timestamp)) <= 30

-- 7-) Extract ve groupBy ile hangi siparişin hangi ayda verildiğini getiren sorgu
select extract (month from order_date),order_number from orders group by order_date, order_number

-- 8-) Extract ve groupBy ile bir ayda kaç adet sipariş verildiğini getiren sorgu
select extract (month from order_date),count(*) from orders group by  extract (month from order_date)

-- 9-) Son 3 yılda işe giren çalışanları getiren sorgu
select * from employees where (date_part('year', employment_date::timestamp))>2020

-- 10-) En çok personel alınan ayları listeleyen sorgu
select extract (month from employment_date),count(*) from employees 
group by  extract(month from employment_date) 
