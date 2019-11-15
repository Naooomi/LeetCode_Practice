// Sometime get confused about using left < right or left <= right, left = mid + 1 or left = mid, right = mid - 1 or right = mid
// the below template can handle almost 90% binary search(NOT 100%)

while(left + 1 < right)
{
    int mid = left + (right - left) / 2;

    if (nums[mid] == target)
    {
        return nums[mid];
    }
    else if (nums[mid] < target)
    {
        left = mid;
    }
    else 
    {
        right = mid;
    }
}
