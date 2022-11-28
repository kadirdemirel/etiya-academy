# SQL Homework
### Insert Command
```sh
insert into products(name,stock,description,image_url,unit_price)
values('laptop',100,'Ultra performanslı laptop.','laptop.png',10000)
```
![](images/insert.png)
### Delete Command
```sh
Delete from products where id=7
```
![](images/delete.png)
### Update Command
```sh
Update products set unit_price=12000 where id=7
```
![](images/update.png)
### Between Command
```sh
select name, as "Ürün Adı", unit_price as "Ürün Fiyatı"
from products
where unit_price between 100 and 200
```
![](images/between.png)
### In Command
```sh
select ci.name as "Şehir", ic.first_name as "Ad", ic.last_name as "Soyad"
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
```
![](images/in.png)
### Group By Command
```sh
select p.name as "Ürün Adı", c.name as "Kategori Adı"
from product_categories pc
inner join products p
on pc.product_id = p.id
inner join categories c
on pc.category_id = c.id
group by p.name, c.name
```
![](images/groupby.png)
### Inner Join Command
```sh
select max(pr.unit_price) as "Ürün Ücreti", pr.name as "Ürün Adı"
from baskets ba
inner join basket_items bi
on ba.id = bi.basket_id
inner join products pr
on bi.product_id = pr.id
group by pr.name
```
![](images/innerjoin.png)
### Left Join Command
```sh
select ci.id, t.city_id from cities ci
left join towns t
on ci.id=t.city_id
```
![](images/leftjoin.png)
### Right Join Command
```sh
select * from product_categories p
right join categories c
on p.category_id = c.id
```
![](images/right.png)
### Full Outer Join Command
```sh
select p.name, p.unit_price, bi.quantity, b.total_price from basket_items bi
full outer join baskets b
on bi.basket_id = b.id
full outer join products p
on bi.product_id = p.id
```
![](images/fullouter.png)