#include <bits/stdc++.h>
using namespace std;

void heapify(int arr[], int n, int i)
{
	int smallest = i; 
	int left = 2 * i + 1; 
	int right = 2 * i + 2; 
	if (left < n && arr[l] < arr[smallest])
		smallest = left;

	if (right < n && arr[r] < arr[smallest])
		smallest = right;

	if (smallest != i) {
		swap(arr[i], arr[smallest]);

		heapify(arr, n, smallest);
	}
}

void heapSort(int arr[], int n)
{
	for (int i = n / 2 - 1; i >= 0; i--)
		heapify(arr, n, i);

	for (int i = n - 1; i >= 0; i--) {
		swap(arr[0], arr[i]);

		heapify(arr, i, 0);
	}
}

void printArr(int arr[], int n)
{
	for (int i = 0; i < n; ++i)
		cout << arr[i] << " ";
	cout << "\n";
}

int main()
{
	int arr[] = { 4, 6, 3, 2, 9 };
	int n = sizeof(arr) / sizeof(arr[0]);

	heapSort(arr, n);

	cout << "Sorted array \n";
	printArr(arr, n);
}
