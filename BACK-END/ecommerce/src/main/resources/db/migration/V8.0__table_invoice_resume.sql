drop table if  exists invoice_purchase;

create table invoice_resume(

   invoice_id bigint not null,
   purchase_id bigint not null,
   constraint fk_invoice foreign key (invoice_id) references invoice (invoice_id),
   constraint fk_purchase foreign key (purchase_id) references purchase (purchase_id)

)engine = InnoDB;