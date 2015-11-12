package com.github.rodrigohenriques.mvp.sample.data.entities;

public interface Marshaller<Input, Output> {
    Output marshal(Input input);
    Input unmarshal(Output input);
}
