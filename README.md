# SimplMind
*A very very simple Feedforward Neural Network library in Java*

SimplMind was developed as way for me to further my understanding of Neural Network and as a result is not optimised in any way shape or form. If you do decide you want to used this library, enjoy.

## Features
- Vectorized - uses a matrix implementation to process training data
- Configurable - allows you to customize the network topology

## Creating a Mind
To create a mind you must first decide on its topology, this is done by creating input, hidden and output layers.
```
//Layers can have diffrent activation function, the default is sigmoid, linear and hyperbolic tangent are also avalible
Layer in = new Layer(42, 2);

//The hidden section can be specifed as either a single layer or an array of layers
Layer hidden = new Layer(22);
Layer[] hidden = new Layer[]{new Layer(22), new Layer(10)};

Layer out = new Layer(3);
    
```
After you have created the required layers you can constuct a Mind
```
// The final variables tells us if the mind should normalize data or not
Mind test1 = new Mind(in, hidden, out, true);
```


