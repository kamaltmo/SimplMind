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
Layer in = new Layer(2, 2);

//The hidden section can be specifed as either a single layer or an array of layers
Layer hidden = new Layer(3);
Layer[] hidden = new Layer[]{new Layer(3), new Layer(2)};

Layer out = new Layer(1);
    
```
After you have created the required layers you can constuct a Mind
```
// The final variables tells us if the mind should normalize data or not
Mind test = new Mind(in, hidden, out, true);
```

## Teaching and Testing
Now that you have created a mind you can teach it using an array of inputs and an array of expected outputs
```
//Train Network with training data and desired output
test.learn(new double[][]{{0,0},{0,1},{1,0},{1,1}}, new double[][]{{0},{1},{1},{0}});
```
When your network has been succesfully trained you can use it to make predictions based on an input array
```
double[][] result = test.predict(new double[][]{{1,0},{0,1},{1,1},{0,0}});
```

The above covers the basics of how to set up, train and use and neural network using SimplMind. Simpl offers some more features such as the ability to change the number of iterations, the scaling factor, the activation function, etc. An example of these features can be seen in the Tester.java file
