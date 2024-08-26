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
    
    public static int[] reArrangeElementBySign(int []arr){
        int prevEle=arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = i; j < arr.length; j++) {
//                if(arr[0]<0 && arr[j]>0){
//                    prevEle=arr[0];
//                    shiftArray(arr,0,j,arr[j]);
//                    break;
//                }
//                if(prevEle>0 && arr[j]<0 || prevEle<0 && arr[j]>0){
//                    shiftArray(arr,i,j,arr[j]);
//                    prevEle=arr[i];
//                    break;
//                }
//            }
//        }
        // TC-> O(n) + O(n/2) , SC-> (n)
//        int [] positive=new int[arr.length/2];
//        int [] negative=new int[arr.length/2];
//        int left=0,right=0;
//        for(int i : arr){
//            if(i > 0){
//                positive[left++]=i;
//            }else if(i<0){
//                negative[right++]=i;
//            }
//        }
//        for(int i=0;i<arr.length/2;i++){
//            arr[i*2]=positive[i];
//            arr[2 * i + 1]=negative[i];
//        }
//        return arr;

        // TC -> O(n) SC->O(n)
//        int pos=0,neg=1;
//        int [] ans=new int[arr.length];
//        for (int j : arr) {
//            if (j > 0) {
//                ans[pos] = j;
//                pos += 2;
//            } else if (j < 0) {
//                ans[neg] = j;
//                neg += 2;
//            }
//        }
//        return ans;

        // TC -> O(n) + O(min(pos,neg) + O(leftover) = O(2n) if all the values is neg or pos
        // SC-> O(n)
        ArrayList<Integer> positive=new ArrayList<>();
        ArrayList<Integer> negative=new ArrayList<>();
        for(int i : arr){
            if(i > 0){
                positive.add(i);
            }else if(i<0){
                negative.add(i);
            }
        }
        int i,count=0;
        for(i=0;i<Math.min(positive.size(),negative.size());i++){
            arr[i*2]=positive.get(i);
            arr[2 * i + 1]=negative.get(i);
            count+=2;
        }
        while (i<positive.size()){
            arr[count++]=positive.get(i++);
        }
        while (i<negative.size()){
            arr[count++]=negative.get(i++);
        }
        return arr;
    }
    public static void shiftArray(int []arr, int left,int right,int elem){
        while (right>left){
            int temp=arr[right];
            arr[right]=arr[right-1];
            arr[right-1]=temp;
            right--;
        }
        arr[left]=elem;
    }

    public static void nextPermutation(int [] arr){
        // Brute force
        // to generate N permutation we need N! and to generate for N number
        // we will need N so Total TC-> N! * N
        // it is very large 5!= 120 15!=10^12 which is very high, so we do
        // not use brute force
        // 1.Generate all sorted 2.Linear Search 3.Next is my answer


        //TC -> O(3N) optimal
        int index=findDipNextPermutation(arr);
        if(index == -1){
            System.out.println("init");
            int i=0,j=arr.length-1;
            while (i<=j && j<arr.length){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }

        }else {
            findSmallestThanDipNextPermutation(arr[index],index,arr);
            int i=index+1,j=arr.length-1;
            while (i<=j && j<arr.length){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }

            System.out.println(Arrays.toString(arr));
        }


    }
    public static int findDipNextPermutation(int [] arr){
        for (int i = arr.length-2; i >= 0 ; i--) {
            if(arr[i] < arr[i+1]){
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }
    public static void findSmallestThanDipNextPermutation(int val,int index,int [] arr){
        for (int i = arr.length-1; i > index ; i--) {
            if(val < arr[i]){
                int temp=arr[index];
                arr[index]=arr[i];
                arr[i]=temp;
                return;
            }
        }
    }

    public static ArrayList<Integer> LeadersInAnArray(int [] arr){
        ArrayList<Integer> leaders=new ArrayList<>();
        //TC-> O(n^2)
//        for(int i=0;i<arr.length;i++){
//            boolean leaderConfirm=true;
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[j]>arr[i]){
//                    leaderConfirm=false;
//                    break;
//                }
//            }
//            if(leaderConfirm && !leaders.contains(arr[i])){
//                leaders.add(arr[i]);
//            }
//        }
        // TC -> O(n) sc-> answer O(n)
        int max=arr[arr.length-1];
        leaders.add(max);
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>max){
                max=arr[i];
                leaders.add(arr[i]);
            }
        }
//        Collections.sort(leaders);
        return leaders;
    }

    public static int longestConsecutive(int[] nums) {
//        int ans=1,previousAns=0;
        // HashMap<Integer,Integer> map =new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     map.put(nums[i],i);
        // }

        // for(int i=0;i<nums.length;i++){
        //     int target=nums[i]+1;
        //     ans=1;
        //     while(map.containsKey(target)){
        //         target=target+1;
        //         ans++;
        //     }
        //     previousAns=Math.max(ans,previousAns);
        // }
        // int c=0;
        // int target=nums[0];
        //  while(c<nums.length{
        //     if(map.containsKey(target)){
        //         ans++;
        //         target=target+1;
        //     }
        //     ans=1;
        //     while(map.containsKey(target)){
        //         target=target+1;
        //         ans++;
        //     }
        //     previousAns=Math.max(ans,previousAns);
        // }

        // TC->O(nlog n) + O(n)
//        Arrays.sort(nums);
//        int lastSmaller=Integer.MIN_VALUE;
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]-1 == lastSmaller){
//                lastSmaller=nums[i];
//                ans++;
//            }else if(nums[i] != lastSmaller){
//                lastSmaller=nums[i];
//                ans=1;
//            }
//            previousAns=Math.max(ans,previousAns);
//        }
        // TC-> O(n) + O(2)(for while)
        if(nums.length==0){
            return 0;
        }
        int longest=1;
        Set<Integer> st=new HashSet<>();

        for(int i:nums){
            st.add(i);
        }

        for(int i : st){
            if(!st.contains(i-1)){
                int cnt = 1;
                int x = i;
                while (st.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }



        return longest;
    }

    public static void setZeroes(int[][] matrix) {
        //(https://youtu.be/N0MgLvceX7M?si=MjCTxzAYCxDREllf)
        // TC-> O(m*n) + O(n) + O(m) SC -> O(m+n)
        ArrayList<Integer> row=new ArrayList<>();
        ArrayList<Integer> colm=new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0; j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    colm.add(j);
                }
            }
        }
        for(int i : row){
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j]=0;
            }
        }

        for(int i : colm){
            for(int j=0;j<matrix.length;j++){
                matrix[j][i]=0;
            }
        }

//        optimal Solution
//        // int[] row = new int[n]; --> matrix[..][0]
//        // int[] col = new int[m]; --> matrix[0][..]
//
//        int col0 = 1;
//        // step 1: Traverse the matrix and
//        // mark 1st row & col accordingly:
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (matrix.get(i).get(j) == 0) {
//                    // mark i-th row:
//                    matrix.get(i).set(0, 0);
//
//                    // mark j-th column:
//                    if (j != 0)
//                        matrix.get(0).set(j, 0);
//                    else
//                        col0 = 0;
//                }
//            }
//        }
//
//        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                if (matrix.get(i).get(j) != 0) {
//                    // check for col & row:
//                    if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
//                        matrix.get(i).set(j, 0);
//                    }
//                }
//            }
//        }
//
//        //step 3: Finally mark the 1st col & then 1st row:
//        if (matrix.get(0).get(0) == 0) {
//            for (int j = 0; j < m; j++) {
//                matrix.get(0).set(j, 0);
//            }
//        }
//        if (col0 == 0) {
//            for (int i = 0; i < n; i++) {
//                matrix.get(i).set(0, 0);
//            }
//        }
//
//        return matrix;
    }

    public void rotate(int[][] matrix) {
        // int l=0,r=matrix.length-1;
        // while (l<r){
        //     for(int i=0;i<(r-l);i++){
        //         int top=l,bottom=r;
        //         int topLeft = matrix[top][l+i];
        //         matrix[top][l+i]=matrix[bottom-i][l];
        //         matrix[bottom-i][l]=matrix[bottom][r-i];
        //         matrix[bottom][r-i]=matrix[top+i][r];
        //         matrix[top+i][r]=topLeft;

        //     }
        //     r-=1;
        //     l+=1;
        // }

        // for(int[] mat:matrix){
        //     System.out.println(Arrays.toString(mat));
        // }


        //TC ->O(n^2) SC-> O(n^2)
        int [][] ans=new int[matrix.length][matrix.length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                ans[j][matrix.length-1-i]=matrix[i][j];
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                matrix[i][j]=ans[i][j];
            }
        }
        // TC -> O(n/2 * n/2) + O(nlog n) SC->O(1)
        for(int i=0;i<matrix.length-1;i++){
            for(int j=i+1;j<matrix[i].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;

            }
        }

        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }

        for(int i=0;i<matrix.length;i++){
            reverseArray(matrix[i]);
        }

    }
    public void reverseArray(int [] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static List<Integer> SpiralTraversalOfMatrix(int [][] mat) {
        // TC->O(n*n) SC->O(n*n)
        List<Integer> ans = new ArrayList<>();

        int n = mat.length; // no. of rows
        int m = mat[0].length; // no. of columns

        // Initialize the pointers required for traversal.
        int top = 0, left = 0, bottom = n - 1, right = m - 1;

        // Loop until all elements are not traversed.
        while (top <= bottom && left <= right) {

            // For moving left to right
            for (int i = left; i <= right; i++)
                ans.add(mat[top][i]);

            top++;

            // For moving top to bottom.
            for (int i = top; i <= bottom; i++)
                ans.add(mat[i][right]);

            right--;

            // For moving right to left.
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    ans.add(mat[bottom][i]);

                bottom--;
            }

            // For moving bottom to top.
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(mat[i][left]);

                left++;
            }
        }
        return ans;
    }

    public static List<List<Integer>> pascalTriangle(int n){

        // TO find the element if row and column is given
        // formula is nCr = n!/r!*(n-r)! n=row-1 r=colm-1
//        int n=4,r=2;
//        int answer = factorial(n)/(factorial(r) * factorial((n-r)));
//
//        double ans=1.0;
//        for(int i=0;i<r;i++){
//            ans*= (double) (n - i) /(i+1);
//        }
//        System.out.println((int) ans);
        List<List<Integer>> answer=new ArrayList<>();
        for (int i=1;i<=n;i++){
            answer.add(getPascalRow(i));
        }
        return answer;
    }
    public static List<Integer> getPascalRow(int row){
        List<Integer> pasCalRow=new ArrayList<>();
        int ans=1;
        pasCalRow.add(ans);
        for(int col=1;col<row ; col++){
            ans*= row-col;
            ans/=col;
            pasCalRow.add(ans);

        }
        return pasCalRow;
    }
    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n * factorial(n-1);
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
//        int[] a = getRandomArray(5,10,-10);

        int[] a = {
                1, 2, 2, 1
        };

//        int[] b = getRandomArray(5);
//        Arrays.sort(a);
//        Arrays.sort(b);
//        System.out.println("Total Array A" + Arrays.toString(a));
//        System.out.println("Total Array B" + Arrays.toString(b));
//        System.out.println("Total Array ANS : " + Arrays.toString(reArrangeElementBySign(a)));
//        System.out.println("Total Array ANS : " + LeadersInAnArray(a));
//        nextPermutation(a);
        for (List<Integer> i : pascalTriangle(12)) {
            System.out.println(i);
        }
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
