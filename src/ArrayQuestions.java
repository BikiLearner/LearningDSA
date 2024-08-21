import java.util.*;

public class ArrayQuestions {


    public static int largestElementInArray(int[] arr) {
        //Brute force solution
//        Arrays.sort(arr);
//        return arr[arr.length-1];


        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static int secondLargestElementInArray(int[] arr) {

        //Brute force solution O(nlog n + n)
//        Arrays.sort(arr);
//        int largestElement=arr[arr.length-1];
//        int secondLarge=-1;
//        for(int i=arr.length-2;i>=0;i--){
//            if(arr[i]!=largestElement){
//                secondLarge=arr[i];
//                break;
//            }
//        }
//        return secondLarge;

        //Better solution O(2n)
//        int largest=arr[0];
//        for (int j : arr) {
//            if (largest < j) {
//                largest = j;
//            }
//        }
//        int secondLarge=-1;
//        for(int i : arr){
//            if(i>secondLarge && i!=largest){
//                secondLarge=i;
//            }
//        }
//
//        return secondLarge;
        //optimal solution O(n)
        int largest = arr[0], second = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                second = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > second) {
                second = arr[i];
            }
        }
        int[] ar2 = {1, 2};
        return second;


    }

    public int secondSmallestElement(int[] a) {

        int sSmallest = Integer.MAX_VALUE;
        int smallest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < smallest) {
                sSmallest = smallest;
                smallest = a[i];
            } else if (a[i] != smallest && a[i] < sSmallest) {
                sSmallest = a[i];
            }
        }
        return sSmallest;
    }

    public static boolean checkArraySortedOrNot(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }

    public static int removeDuplicate(int[] arr) {
        //Brute force O(nlog n + n) SC-> O(n)
//        Set<Integer> noDuplicate=new HashSet<>();
//        for(int i=0;i<arr.length;i++){
//            noDuplicate.add(arr[i]);
//        }
//        int index=0;
//        for (int a : noDuplicate){
//            arr[index++]=a;
//        }
//        return index;

        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        return (i + 1);
    }

    public static void leftRotateArrayByOnePlace(int[] arr, int start) {
        //tc -> O(n)
        //SC-> O(1)
        // if some one says extra space then O(1)
        // if some say space use in algo O(n) due to the array use
        int temp = arr[start];
        int i;
        for (i = start; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[i] = temp;
    }

    public static ArrayList<Integer> leftRotateArrayByDPlace(int[] a, int D) {
        //USE SET IN ARRAY LIST TO SET VALUE TO CERTAIN INDEX
        // DON't use add

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : a) {
            arr.add(i);
        }
        System.out.println(D);
        int iterationCount = 0;
        for (int j = 1; j <= (D % arr.size()); j++) {
            System.out.println(++iterationCount);
            int temp = arr.getFirst();
            int i = 0;
            for (; i < arr.size() - 1; i++) {

                arr.set(i, arr.get(i + 1));
            }
            arr.set(i, temp);
        }
        return arr;
    }

    public void rotate(int[] nums, int k) {
        //O(n)
        // sc -> O(d);
        int n = nums.length;
        // System.out.println(n);
        // int d=(k % n);
        // System.out.println(d);
        // int []temp=new int[d];
        // for (int j = 0; j < d; j++) {
        //     temp[j]=nums[n-1-j];
        // }

        // for (int i = n-1; i >= d ; i--) {
        //         nums[i]=nums[i-d];
        // }
        // for(int i=0;i<d;i++){
        //     nums[i]=temp[d-1-i];
        // }


        //Tc -> O(2n)
        //sc-> O(1)
        int d = (k % n);
        reverse(nums, 0, n - d);
        reverse(nums, n - d, n);
        reverse(nums, 0, n);


    }

    public void reverse(int[] arr, int vali, int n) {
        int i = vali, j = n - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void moveZeroToEnd(int[] arr, int n) {
//        boolean sap=true;
//        int count=0;
//        while (sap || count<n-1){
//            sap=false;
//            for(int i=0;i<=n-2-count;i++){
//                if(arr[i]==0){
//                    int temp=arr[i];
//                    arr[i]=arr[i+1];
//                    arr[i+1]=temp;
//                    sap=true;
//                }
//            }
//            count++;
//        }

        //better soln done by me
        //O(n^2) worst case O(n)
//        int i=0,c=n;
//        while (i<c){
//            if(arr[i]==0){
//                leftRotateArrayByOnePlace(arr,i);
//                c--;
//            }else {
//                i++;
//            }
//        }
        // TC -> O(n), Sc->O(1)
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (arr[j] == 0 && arr[i] != 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            } else if (arr[j] != 0) {
                j++;
            }
        }


    }

    public static int linearSearch(int[] arr, int n, int key) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                return -1;
            }
        }
        return key;
    }


    public static int[] unionArray(int[] arr1, int[] arr2) {

        //O(n1log n  + n2log n ) + O(n1 + n2)
        //Sc-> O(n1 + n2) + O(n1+n2)
//        Set<Integer> integerSet=new HashSet<>();
//
//        //O(nlog n)
//        for (int i : arr1){
//            integerSet.add(i);
//        }
//        for (int i : arr2){
//            integerSet.add(i);
//        }
//        int j=0;
//        int []arr=new int[integerSet.size()];
//        for (int i : integerSet){
//            arr[j++]=i;
//        }

        // TC -> O(n1 + n2)
        // SC-> O(n1 + n2)
        ArrayList<Integer> unionList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                if (unionList.isEmpty() || unionList.getLast() != arr1[i]) {
                    unionList.add(arr1[i]);
                }
                i++;

            } else {
                if (unionList.isEmpty() || unionList.getLast() != arr2[j]) {
                    unionList.add(arr2[j]);
                }
                j++;

            }
        }
        while (i < arr1.length) {
            if (unionList.isEmpty() || unionList.getLast() != arr1[i]) {
                unionList.add(arr1[i]);
            }
            i++;
        }
        while (j < arr2.length) {
            if (unionList.isEmpty() || unionList.getLast() != arr2[j]) {
                unionList.add(arr2[j]);
            }
            j++;
        }

        int[] arr = new int[unionList.size()];
        int c = 0;
        for (int p : unionList) {
            arr[c++] = p;
        }

        return arr;
    }

    public static int[] interSection(int[] arr1, int[] arr2) {

        //TC -> O(n1 * n2)
        //SC-> O(n2)
        ArrayList<Integer> unionList = new ArrayList<>();
//        int []visited=new int[arr2.length];
//        for(int i=0;i< arr1.length;i++){
//            for (int j = 0; j < arr2.length ; j++) {
//                if(arr1[i]==arr2[j] && visited[j]==0){
//                    unionList.add(arr1[i]);
//                    visited[j]=1;
//                }
//                if(arr1[i]<arr2[j]) break;
//            }
//        }
        // TC -> O(n1 + n2)
        // TC -> O(1)
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else if (arr1[i] == arr2[j]) {
                unionList.add(arr1[i]);
                i++;
                j++;
            }
        }


        int[] arr = new int[unionList.size()];
        int c = 0;
        for (int p : unionList) {
            arr[c++] = p;
        }

        return arr;
    }

    public static int missingNumber(int[] a, int N) {

        // TC -> O(n * n)
        // SC -> O(1)
//        for(int i=1;i<=n;i++){
//            missing=linearSearch(arr,arr.length,i);
//            if(missing!=-1){
//                return missing;
//            }
//        }


        //TC -> O(n)+ O(n)
        // Sc-> O(n)

        int missing = -1;
//        int [] visited=new int[N+1];
//        for (int i=0;i<a.length;i++){
//            visited[a[i]]=a[i];
//        }
//        System.out.println(Arrays.toString(visited));
//        for (int i=1;i<=N;i++){
//            if(visited[i]!=i){
//                missing=i;
//                return missing;
//            }
//        }
        //TC -> O(N)
        // SC-> O(1)
//        int sum=(N*(N+1))/2;
//        int arrSum=0;
//
//        for (int i : a){
//            arrSum+=i;
//        }
//        return (sum-arrSum);

        // TC -> O(n) + O(n)
        int xorVal1 = 0;
        int xorVal2 = 0;
        for (int i = 0; i < N; i++) {
            if (a.length != i) {
                xorVal2 = xorVal2 ^ a[i];
            }
            xorVal1 = xorVal1 ^ (i + 1);

        }
        System.out.println(xorVal1 + " " + xorVal2);
        return (xorVal1 ^ xorVal2);
    }

    public static int maximumConsecutiveOnes(int[] arr) {
        //TC -> O(n)
        int count = 0;
        int prevCount = 0;
        for (int i : arr) {
            if (i != 1) {
                if (prevCount < count) {
                    prevCount = count;
                }
                count = 0;
            } else {
                count++;
            }
        }
        return prevCount;
    }

    public static int numberThatAppearsOnceOtherAppearsTwice(int[] arr) {

//        int max=arr[0];
//        for (int i = 0; i < arr.length ; i++) {
//            max=Math.max(max,arr[i]);
//        }
//        int [] hashMax=new int[max];
//        for (int i = 0; i < arr.length ; i++) {
//            hashMax[arr[i]-1]++;
//
//        }
//
//        for (int i = 0; i < hashMax.length ; i++) {
//            if(hashMax[i]==1)
//                return i+1;
//        }
//        return -1;

        //if we use xor
        //TC -> O(n) , SC->O(1)
        int xor = 0;
        for (int j : arr) {
            xor = j ^ xor;
        }
        return xor;
    }

    public static int longestSubArrayWithSumK(int[] arr, long k) {
//        int count,savedCount=0;
//        for(int i=0;i<arr.length;i++){
//            int sum=0;
//            count=0;
//            for(int j=i;j<arr.length;j++){
//                sum+=arr[j];
//                count++;
//                if(sum==k){
//                    savedCount=Math.max(savedCount,count);
//                }
//            }
//        }

        //TC - > O(n * log n) if using order map else O(n * 1) for optimal  and O(n * n ) for worst
        //SC-> O(n)
        //it is optimal for negative number in array
//        long preSum=0;
//        int len=0;
//        HashMap<Long,Integer> perSumMap=new HashMap<>();
//        for (int i=0;i<arr.length;i++){
//            preSum=preSum+arr[i];
//
//            if(preSum==k){
//                len=i+1;
//            }
//            long nval=preSum-k;
//            if(perSumMap.containsKey(nval)){
//                int val=i-(perSumMap.get(nval));
//                len=Math.max(len,val);
//            }
//
//            if(!perSumMap.containsKey(preSum)){
//                perSumMap.put(preSum,i);
//            }
//
//        }

        //TC -> O(2n) , sc->O(1)
        int i = 0, j = 0;
        long sum = arr[0];
        int savedCount = 0;

        while (j < arr.length) {
            //it needs to b loop
//            if (sum>k) {
//                sum=sum-arr[i];
//                i++;
//            }
            while (i <= j && sum > k) {
                sum = sum - arr[i];
                i++;
            }
            if (sum == k) {
                savedCount = Math.max((j - i + 1), savedCount);
                System.out.println(savedCount);
            }
            j++;
            if (j < arr.length) sum = sum + arr[j];

        }
        return savedCount;
    }

    public static int countNoOfSubArray(int[] arr, int k) {
        int totalSubArray = 0, preSum = 0;
        HashMap<Integer, Integer> hashPresum = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];
            if (preSum == k) totalSubArray++;

            if (hashPresum.containsKey(preSum - k)) {
                totalSubArray += hashPresum.get(preSum - k);
            }

            hashPresum.put(preSum, hashPresum.getOrDefault(preSum,0)+1);


        }

        return totalSubArray;
    }
    public static int[] twoSum(int []arr,int target){
        int [] ans=new int[2];
//        for (int i=0;i<arr.length;i++){
//            for(int j=i;j<arr.length;j++){
//                int sum=arr[i]+arr[j];
//                if(sum==target){
//                    ans[0]=i;
//                    ans[1]=j;
//                }
//            }
//        }
        //TC -> O(nlog n) sc-> O(n)
        HashMap<Integer,Integer> arrayStore=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            arrayStore.put(arr[i],i);
        }
        for(int i=0;i<arr.length;i++){
            if(arrayStore.containsKey(target-arr[i])){
                ans[1]=i;
                ans[0]=arrayStore.get(target-arr[i]);
                return ans;
            }
        }
        //Tc-> O(n) + O(nlog n), SC->(n)
        Arrays.sort(arr);
        int left=0,right=arr.length-1;
        while (left<=right){
            int sum=arr[left]+arr[right];
            if(sum==target){
                ans[0]=left;
                ans[1]=right;
                return ans;
            }
            if(sum>target){
                right--;
            }else {
                left++;
            }

        }
        return new int[]{-1,-1};
    }

    public static int[] sortO12Array(int [] arr){
        //Better solution
        // Tc -> O(2N)
//
//        int count0=0,count1=0,count2=0;
//        for (int i : arr){
//            if(i ==0 ) count0++;
//            else if (i == 1) count1++;
//            else count2++;
//        }
//        for(int i=0;i<count0;i++){
//            arr[i]=0;
//        }
//        for(int i=count0;i<count0+count1;i++){
//            arr[i]=1;
//        }
//        for(int i=count0+count1;i<arr.length;i++){
//            arr[i]=2;
//        }
//        return arr;

        //Dutch National flag Algo
        //it state that
        //[O ... low] extreme left = 0
        //[low ... mid-1]  = 1
        //[high+1 ... n-1] extreme right = 2
        //[mid ... high] random numbers 0/1/2(unsorted)

        //TC -> O(n) SC->O(1)

        int low=0,mid=0,high=arr.length-1;

        while (mid<=high){
            if(arr[mid]==0){
                int temp=arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                mid++;
                low++;
            }else if(arr[mid]==1){
                mid++;
            }else if(arr[mid]==2) {
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }
        return arr;
    }

    public static int majorityNby2(int [] arr,int N){
        //*(https://youtu.be/nP_ns3uSh80?si=IxnBXSAQzMUHzlbX)
        //TC -> O(nlog n) + O(n) SC->O(n)
//        HashMap<Integer,Integer> countOccurrence=new HashMap<>();
//        for (int j : arr) {
//            countOccurrence.put(j, countOccurrence.getOrDefault(j, 0) + 1);
//        }
//        for(Map.Entry<Integer,Integer> mapVal:countOccurrence.entrySet()){
//            if(mapVal.getValue()>(N/2)){
//                return mapVal.getKey();
//            }
//        }
//        return -1;

        //Moore's Voting algo
        // TC -> O(n) the second step will not be done if problem state that there
        // always has majority element else TC-> O(n+n)
        //SC-> O(1)
        int cnt=0;
        int ele=arr[0];

        for (int j : arr) {
            if (cnt == 0) {
                cnt = 1;
                ele = j;
            } else if (j == ele) {
                cnt++;
            } else {
                cnt--;
            }
        }

        int counter=0;
        for(int i: arr){
            if(i==ele) counter++;
        }
        if (counter>(N/2)) return ele;

        return -1;


    }

    public static int MaximumSubArraySum(int [] arr){
        //(https://youtu.be/AHZpyENo7k4?si=exTsjROjAj5I8g1w)
        int prevSum=Integer.MIN_VALUE,sum=0;
//        for(int i=0;i<arr.length;i++){
//            sum=0;
//            for(int j=i;j<arr.length;j++){
//                sum+=arr[j];
//                prevSum = Math.max(prevSum,sum);
//            }
//        }
//        return prevSum;
        // TC -> O(n) Sc->O(1)


        for (int j : arr) {
            sum += j;

            prevSum = Math.max(prevSum, sum);
            if (sum < 0) {
                sum = 0;

            }
        }
        return prevSum;
    }
    public int maxProfit(int[] prices) {
        int maxProfit=0,mini=prices[0];

        //TC->O(n) SC->O(1)
        //why dc as because I am remembering the past
        for(int i=1;i<prices.length;i++){
           int sum=prices[i]-mini;
           maxProfit=Math.max(sum,maxProfit);
           mini=Math.min(mini,prices[i]);
        }



        return maxProfit;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < n; i++) {
//            a[i] = i + 1;
//        }
//        System.out.println("Total Array" + Arrays.toString(a));
//        Arrays.sort(a);
//        System.out.println("Total Array" + Arrays.toString(a));
//
//        int uniqueN=removeDuplicate(a);
//        System.out.println(uniqueN);
//        System.out.println("Unique Elements");
//        for(int i=0;i<uniqueN;i++){
//            System.out.print(a[i]+", ");
//        }

//        moveZeroToEnd(a,n);
        int[] a = getRandomArray(5,10,-10);

//        int[] a = {
//                2,6,5,8,11
//
//        };

//        int[] b = getRandomArray(5);
//        Arrays.sort(a);
//        Arrays.sort(b);
        System.out.println("Total Array A" + Arrays.toString(a));
//        System.out.println("Total Array B" + Arrays.toString(b));
//        System.out.println("Total Array ANS : " + Arrays.toString(sortO12Array(a)));
        System.out.println("Total Array ANS : " + MaximumSubArraySum(a));
    }

    public static int[] getRandomArray(int n, int randVal,int origin) {
        int[] a = new int[n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(origin, randVal);
        }
//        for (int i = 0; i < n; i++) {
//            a[i] = i + 1;
//        }
        return a;
    }


}
