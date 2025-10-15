CREATE TABLE filmes_categoria(
    filmes_id INTEGER,
    categoria_id INTEGER,
    PRIMARY KEY (filmes_id, categoria_id),
    CONSTRAINT fk_filmes_categoria_filmes FOREIGN KEY(filmes_id) REFERENCES filmes(id),
    CONSTRAINT fk_filmes_categoria_categoria FOREIGN KEY(categoria_id) REFERENCES categoria(id)
);