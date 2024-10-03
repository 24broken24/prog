using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _35_2_inevatkin_lab1
{
    public partial class Form1 : Form
    { private double[] _InputPixels = new double[15] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }; 
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            ChangeState(button1, 0);
            label1.Text = _InputPixels[0].ToString();
        }
        private void ChangeState(Button b, int index)
        {
            if(b.BackColor == Color.Black)
            {
                b.BackColor = Color.White;
                _InputPixels[index] = 1d;
            }
            else
            if(b.BackColor==Color.White)
            {
                b.BackColor = Color.Black;
                _InputPixels[index] = 0d;
            }
           
        }
    }
}
