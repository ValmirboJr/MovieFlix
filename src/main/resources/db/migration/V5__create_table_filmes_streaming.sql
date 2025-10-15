CREATE TABLE filmes_streaming (
 filmes_id INTEGER,
 streaming_id INTEGER,
 PRIMARY KEY (filmes_id, streaming_id),
 CONSTRAINT fk_filmes_streaming_filmes FOREIGN KEY(filmes_id) REFERENCES filmes(id),
 CONSTRAINT fk_filmes_streaming_streaming FOREIGN KEY(streaming_id) REFERENCES streaming(id)
);