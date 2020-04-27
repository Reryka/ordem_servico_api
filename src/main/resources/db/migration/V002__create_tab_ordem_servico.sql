CREATE TABLE ordem_servico (
  id bigint NOT NULL AUTO_INCREMENT,
  cliente_id bigint not NULL,
  descricao text not NULL,
  preco DECIMAL(10,2) not NULL,
  status varchar(20) not null,
  data_abertura DATETIME not NULL,
  data_fechamento DATETIME,
  PRIMARY KEY (id),
  INDEX fk_os_cliente_idx (cliente_id ASC) VISIBLE,
  CONSTRAINT fk_os_cliente
    FOREIGN KEY (cliente_id)
    REFERENCES cliente (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION );