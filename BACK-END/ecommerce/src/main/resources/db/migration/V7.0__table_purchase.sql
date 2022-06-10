drop table if exists purchase

create table purchase(

purchase_id bigint not null auto_increment primary key,
amount SMALLINT not null,
product_id not null,
constraint fk_product foreign key (product_id) references product(product_id)

)engine = InnoDB;