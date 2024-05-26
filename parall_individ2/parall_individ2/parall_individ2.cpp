#include <iostream>
#include "mpi.h"
#include <vector>
#include <fstream>
#include <math.h>
using namespace std;
//5. Написать программу, получающую в качестве аргументов n x n матрицу а вещественных чисел, целое число n,
//и заменяющую каждый элемент матрицы( для которого это возможно) на среднее арифметическое соседних элементов. При этом должна быть обеспечена равномерная загрузка
//всех задач. Основная программа должна выводить числа n и матрицу а(из файла или по заданной формуле), и выводить на экран результат работы.

void replaceWithAverage(std::vector<std::vector<double>>& matrix, int n) {
    int rank, size;
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    int elementsPerProcess = n / size;
    int start = rank * elementsPerProcess;
    int end = (rank == size - 1) ? n : start + elementsPerProcess;

    for (int i = start; i < end; i++) {
        for (int j = 0; j < n; j++) {
            double sum = matrix[i][j];
            int count = 1;

            if (i > 0) {
                sum += matrix[i - 1][j];
                count++;
            }
            if (i < n - 1) {
                sum += matrix[i + 1][j];
                count++;
            }
            if (j > 0) {
                sum += matrix[i][j - 1];
                count++;
            }
            if (j < n - 1) {
                sum += matrix[i][j + 1];
                count++;
            }

            matrix[i][j] = sum / count;
        }
    }
}

int main(int argc, char** argv) {
    MPI_Init(&argc, &argv);

    int n;
    std::cin >> n;

    std::vector<std::vector<double>> matrix(n, std::vector<double>(n));
    // Заполнение матрицы из файла или по заданной формуле

    // Вывод исходной матрицы
    std::cout << "Исходная матрица:\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            std::cout << matrix[i][j] << " ";
        }
        std::cout << std::endl;
    }

    replaceWithAverage(matrix, n);

    // Вывод результата
    std::cout << "Результат работы:\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            std::cout << matrix[i][j] << " ";
        }
        std::cout << std::endl;
    }

    MPI_Finalize();
    return 0;
}