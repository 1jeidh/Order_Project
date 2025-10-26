# Yêu cầu cài trước
Java JDK 21 \
Maven ≥ 3.9 \
Docker \
IntelliJ IDEA / VS Code \
Postman 

# Cài đặt và build project
- Trong Terminal gõ: git clone https://github.com/1jeidh/Order_Project.git 
- Tại thư mục gốc của project Order_Project gõ: mvn clean install -DskipTests và docker-compose up -d 
- Dùng lệnh: docker ps để kiểm tra
- docker exec -it postgres-order psql -U order_user -d order_db để truy vấn database
- \dn : xem schema (phải có "order")
- \dt "order".* : xem bảng "order".orders
- SELECT * FROM "order".orders; để xem database
- Mở Postman để test như sau<img width="839" height="348" alt="image" src="https://github.com/user-attachments/assets/53c37883-d642-45fe-b3d0-dbd68527a78b" /> <img width="844" height="495" alt="image" src="https://github.com/user-attachments/assets/3cb58bbb-a65e-4ff7-aaa1-fecbcbaa2cc2" />
- Sau khi Send nhận được kết quả<img width="835" height="150" alt="image" src="https://github.com/user-attachments/assets/7ae65f9c-9403-4514-be9c-d85b7b702680" />
- Vào terminal SELECT * FROM "order".orders; để xem database được cập nhật sau khi test bằng Postman
- mvn clean test để test tất cả Unit hoặc truy cập từng module (order-domain và order-application-service) và gõ mvn test để Unit test độc lập
- Gõ: docker compose down để tắt project (dùng docker compose down -v nếu tạo mới database)

# Vấn đề của project
- Integration Test chưa có / chưa chạy thành công
- Chưa có test E2E tự động, chỉ dùng Postman thủ công để chứng minh được API chạy
- mới chạy 1 service độc lập, chưa có Payment / Restaurant service đầy đủ
