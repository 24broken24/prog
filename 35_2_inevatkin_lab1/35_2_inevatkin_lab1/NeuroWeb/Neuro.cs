using static System.Math;

namespace _35_2_inevatkin_lab1.NeuroWeb
{
    class Neuro
    {
        private NeuronType type; //тип нейрона 
        private double[] _weights; //массив весов 
        private double[] _inputs; //входной массив 
        private double[] _outputs; //выходной массив 
        private double[] _derivative;//производная 
        private double a = 0.01;
        //функция активации гиперболический тангенс
        public double[] Weights { get => _weights; set => _weights = value; }
        public double[] Inputs {get => _inputs; set => _inputs = value;}
        public double[] Outputs { get => _outputs; }
        public double[] Derivative { get => _derivative; }

}
}
