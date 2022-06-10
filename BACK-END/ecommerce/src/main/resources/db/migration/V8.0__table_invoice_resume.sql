drop table if  exists invoice_resume;

create table invoice_resume(

   invoice_id bigint not null,
   resume_id bigint not null,
   constraint fk_invoice foreign key (invoice_id) references invoice (invoice_id),
   constraint fk_resume foreign key (resume_id) references resume (product_id)

)engine = InnoDB;