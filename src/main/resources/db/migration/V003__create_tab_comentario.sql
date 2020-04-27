CREATE TABLE os.comentario (
  id BIGINT NOT NULL AUTO_INCREMENT,
  ordem_servico_id BIGINT NOT NULL,
  descricao TEXT NOT NULL,
  data_envio DATETIME NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_comentario_os_idx (ordem_servico_id ASC) VISIBLE,
  CONSTRAINT fk_comentario_os
    FOREIGN KEY (ordem_servico_id)
    REFERENCES os.ordem_servico (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);