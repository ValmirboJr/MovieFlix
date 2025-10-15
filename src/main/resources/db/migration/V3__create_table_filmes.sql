CREATE TABLE filmes (
    id serial PRIMARY KEY,
    titulo varchar(255) NOT NULL,
    descricao text,
    data_lancamento date,
    avaliacao numeric,
    data_criacao timestamp,
    data_atualizacao timestamp
);