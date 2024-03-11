class Solution {
    public String crackPassword(int[] password) {
        String[] arr = new String[password.length];
        for(int i = 0; i < password.length; i++) {
            arr[i] = String.valueOf(password[i]);
        }
        quickSort(arr, 0, password.length - 1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < password.length; i++) {
            sb.append(arr[i]);
        }
        String res = sb.toString();

        return res;
    }
    public void quickSort(String[] arr, int left, int right) {
        if(left > right)
            return;
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }
    public int partition(String[] arr, int left, int right) {
        String pivot = arr[left];
        int i = left, j = right;
        while(i < j) {
            while(i < j && (arr[j]+pivot).compareTo(pivot+arr[j]) >= 0)
                j--;
            while(i < j && (arr[i]+pivot).compareTo(pivot+arr[i]) <= 0)
                i++;
            // switch
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // switch
        arr[left] = arr[i];
        arr[i] = pivot;

        return i;
    }
}
