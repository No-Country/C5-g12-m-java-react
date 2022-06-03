drop table if  exists invoice_product;

create table invoice_product(

   invoice_id bigint not null,
   product_id bigint not null,
   constraint fk_invoice foreign key (invoice_id) references invoice (invoice_id),
   constraint fk_product foreign key (product_id) references product (product_id)

)engine = InnoDB;