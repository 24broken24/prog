#include <omp.h>
#include <iostream>
#include <algorithm>
//5. Реализовать сортировку массива методом шейкерной сортировки

using namespace std;

void rand_mat(int *arr,int n) {
    for (int i = 0; i < n; i++)
        arr[i] = rand() % 100;
}

void shaker_arr(int* arr, int n)
{
    int left, right, i;
#pragma omp parallel for num_threads(4) private(left, right, i)
    for (int k = 0; k < n / 2; k++) {
        left = 0;
        right = n - 1;
        while (left <= right) {
#pragma omp for
            for (i = right; i > left; i--) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr[i - 1], arr[i]);
                }
            }
            left++;
#pragma omp for
            for (i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr[i], arr[i + 1]);
                }
            }
            right--;
        }
    }
}

int main()
{
    srand(time(0));
    int n;
    cin >> n;
    int* arr = new int[n];
    rand_mat(arr, n);
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl << endl;
    shaker_arr(arr, n);
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }

}

//void Shakermat(int** a, int n) {
//    int left, right, i;
//    left = 0;
//    right = n - 1;
//    while (left <= right) {
//        for (i = right; i >= left; i--) {
//            if (a[i - 1] > a[i]) {
//                swap(a[i - 1], a[i]);
//            }
//        }
//        left++;
//        for (i = left; i <= right; i++) {
//            if (a[i - 1] > a[i]) {
//                swap(a[i - 1], a[i]);
//            }
//        }
//        right--;
//    }
//}


