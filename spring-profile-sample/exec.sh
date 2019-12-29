# -Dでプロファイル指定
#mvn clean compile exec:java -Dexec.mainClass=com.example.Main -Dspring.profiles.active=dev,production

# 環境変数でプロファイル指定
#SPRING_PROFILES_ACTIVE=production,dev mvn clean compile exec:java -Dexec.mainClass=com.example.Main

# -Dと環境変数でプロファイル指定（-Dのものが優先される）
#SPRING_PROFILES_ACTIVE=production mvn clean compile exec:java -Dexec.mainClass=com.example.Main -Dspring.profiles.active=dev

# @ActiveProfilesと-Dと環境変数でプロファイル指定（@ActiveProfilesのものが優先される）
SPRING_PROFILES_ACTIVE=production mvn clean compile test -Dtest=com.example.ProfilePriorityTest -Dspring.profiles.active=dev
