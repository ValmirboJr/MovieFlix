package org.example.movieflix.mapper;

import lombok.experimental.UtilityClass;
import org.example.movieflix.entity.Streaming;
import org.example.movieflix.request.StreamingRequest;
import org.example.movieflix.response.StreamingResponse;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest) {
        return Streaming
                .builder()
                .nome(streamingRequest.nome())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming) {
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .nome(streaming.getNome())
                .build();
    }

}
