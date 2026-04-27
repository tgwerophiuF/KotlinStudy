package solid

/**
 * 날짜: 2025-12-30
 * 주제: single_responsibility_principle
 */

class UserManager {
    private var userId: Int = 0
    private var userPw: String = ""

    // 사용자 정보 저장
    fun saveUser(userId: Int, userPw: String): Boolean {
        if (!validate(userPw)) {
            return false
        }
        this.userId = userId
        this.userPw = userPw
        return true
    }

    // 비밀번호 유효성 검사 (내부 구현 은닉)
    private fun validate(userPw: String): Boolean {
        return userPw.length >= 4
    }

    // 사용자 인증
    fun authenticate(userId: Int, userPw: String): Boolean {
        return this.userId == userId && this.userPw == userPw
    }

    // 필요 시에만 정보 제공 (읽기 전용)
    fun getUserId(): Int = userId
}

fun main() {
    val userManager = UserManager()

    // 사용자 등록
    val isSaved = userManager.saveUser(1, "qwer")
    println("저장 성공: $isSaved")

    // 인증
    val isAuthenticated = userManager.authenticate(1, "qwer")
    println("인증 성공: $isAuthenticated")
}