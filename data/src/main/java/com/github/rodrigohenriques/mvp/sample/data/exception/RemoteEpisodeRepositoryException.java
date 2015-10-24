package com.github.rodrigohenriques.mvp.sample.data.exception;

public class RemoteEpisodeRepositoryException extends Exception {
    public RemoteEpisodeRepositoryException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public RemoteEpisodeRepositoryException(String detailMessage) {
        super(detailMessage);
    }
}
