package assm2;

import java.util.Date;

public class Article {
        private int id;
        private String baseUrl;
        private String title;
        private String description;
        private String content;
        private String thumbnail;
        private Date createdAt;
        private Date updatedAt;
        private Date deletedAt;
        private int status;

        public Article(int id, String baseUrl, String title, String description, String content, String thumbnail, Date createdAt, Date updatedAt, Date deletedAt, int status) {
                this.id = id;
                this.baseUrl = baseUrl;
                this.title = title;
                this.description = description;
                this.content = content;
                this.thumbnail = thumbnail;
                this.createdAt = createdAt;
                this.updatedAt = updatedAt;
                this.deletedAt = deletedAt;
                this.status = status;
        }

        public Article(int id, String baseUrl, String title, String description, String content, String thumbnail, java.sql.Date createdAt, java.sql.Date updatedAt, java.sql.Date deletedAt, int status) {
        }

        public Article() {

        }


        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getBaseUrl() {
                return baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
                this.baseUrl = baseUrl;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }

        public String getThumbnail() {
                return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
        }

        public Date getCreatedAt() {
                return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
                this.createdAt = createdAt;
        }

        public Date getUpdatedAt() {
                return updatedAt;
        }

        public void setUpdatedAt(Date updatedAt) {
                this.updatedAt = updatedAt;
        }

        public Date getDeletedAt() {
                return deletedAt;
        }

        public void setDeletedAt(Date deletedAt) {
                this.deletedAt = deletedAt;
        }

        public int getStatus() {
                return status;
        }

        public int setStatus(){return status;}}
               