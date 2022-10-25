// Taken from https://leetcode.com/problems/triangle/submissions/

func minimumTotal(triangle [][]int) int {

	for level := len(triangle) - 2; level >= 0; level-- {
		for i := 0; i < len(triangle[level]); i++ {
			minBelow := chooseMin(triangle[level+1][i], triangle[level+1][i+1])
			triangle[level][i] = triangle[level][i] + minBelow
		}
	}
	return triangle[0][0]
}

func chooseMin(left, right int) int {
	if left < right {
		return left
	}
	return right
}