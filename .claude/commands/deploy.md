請依照以下步驟，自動將目前專案部署到 GitHub。目標倉庫：https://github.com/Chi-Liang/claudeProject.git

## 執行步驟

**步驟 1：確認 git 倉庫狀態**

執行 `git status`，確認目前工作區狀態。若尚未初始化，執行：
```
git init
git remote add origin https://github.com/Chi-Liang/claudeProject.git
git branch -M main
```

若已初始化，執行 `git remote -v` 確認遠端指向正確。

**步驟 2：查看變更內容**

執行 `git diff` 顯示未暫存的變更，讓使用者確認有哪些修改。

**步驟 3：暫存程式碼檔案**

只暫存 `demo/src/` 下的原始碼與 `demo/pom.xml`、`.gitignore`、`.claude/commands/` 等必要檔案。
絕對不暫存：`target/`、`.idea/`、`*.iml`、`.claude/settings.local.json`、`.env`、`*.key`。

執行 `git add` 加入適當檔案後，執行 `git diff --cached` 顯示將提交的內容，請求使用者確認。

**步驟 4：請使用者輸入 commit 訊息**

詢問使用者這次變更的原因（commit message），等待回覆後再繼續。

**步驟 5：提交並推送**

```
git commit -m "<使用者提供的訊息>"
git push origin main
```

推送完成後，顯示 `git log --oneline -5` 確認最新提交已在遠端。

**若推送失敗（遠端有新提交）：**
先執行 `git pull --rebase origin main`，解決衝突後再推送。

**部署完成後，回報：**
- 本次提交的 commit hash
- 推送是否成功
- 倉庫連結：https://github.com/Chi-Liang/claudeProject
