---
name: commit-helper
description: 根據目前未提交的變更(git diff)產生一則 commit message。當使用者要求寫 commit message、或問「這次改了什麼」時使用。
---

## 目前的變更
!`git diff HEAD`

## 指示
1. 根據上面的 diff,用英文寫一則簡潔的 commit message(標題 + 條列重點)。
2. 標題請用祈使句,例如「Fix login page validation error」。
3. 如果 diff 是空的,就告訴使用者目前沒有未提交的變更。
4. 額外提醒任何看起來危險的東西,例如寫死的密碼、少了錯誤處理。
