import createView from "../createView.js";

export default function PostIndex(props) {
    return `
                <header>
            <h1>Posts Page</h1>
        </header>
        <main>
            <form>
                <div class="form-group">
                    <label for="title">Title</label>
                    <input id="title" name="title" type="text" placeholder="Enter Blog Title">
                    <div class="form-group">
                        <label for="content">Content</label>
                        <textarea class="form-control" id="content" rows="4" name="content" type="text"
                                  placeholder="Whats on your mind?"></textarea>
                    </div>

                    <div class="form-group row">
                        <button name="addPost" type="button" class="btn btn-primary">Add Post</button>
                    </div>
            </form>

            </div>
            <div class="post-container">
                ${props.posts.map(post => `
                <div class="post">
                    <input class="edit-title" value="${post.title}" readonly>
                    <input class="edit-content" value="${post.content}" readonly>
                    <button class="edit-post-btn" data-id=${post.id}>Edit</button>
                    <button class="delete-post-btn" data-id=${post.id}>Delete</button>
                </div>
                `
    ).join('')}
            </div>
        </main>
    `;
}


function createPost() {
    $('#addPost').click(function() {
        let newPost = {
            title: $('#title').val(),
            content: $('#content').val(),
        }
    })
    let request = {
        method: "POST",
        headers: {"Content-Type":"application/json"},
        body: JSON.stringify(post)
    }
    fetch("http://localhost:8080/posts", request)
        .then((res => {
            console.log(res.status);
            createView("/posts")
        }).catch(error => {
            console.log(error);
            createView("/posts")
        }));
}

function editPost(){
    $('.edit-post-btn').click(function(){



        $(".edit-title, .edit-content").attr("readonly", false);
        $(this).siblings(".edit-title, .edit-content").attr("readonly", true);
        $(this).text("Save");

        $(this).on("click", submitEdit)
})}

function submitEdit(){
    let post = {
        title: $(this).siblings(".edit-title").text(),
        content: $(this).siblings(".edit-content").text(),
    }
    $(this).off("click", submitEdit);
    let id = $(this).attr("data-id");
    let request = {
        method: "PUT",
        headers: {"Content-Type":"application/json"},
        body: JSON.stringify(post)
    }
    fetch(`http://localhost:8080/api/posts/${id}`, request)
        .then((res => {
            console.log(res.status);
            createView("/posts")
        }).catch(error => {
            console.log(error);
            createView("/posts")
        }));
}

function deletePost() {
    let request = {
        method: "DELETE",
        headers: {"Content-Type":"application/json"},
    }
    $(".delete-post-btn").click(function (){
        let id = e.target.getAttribute('data-id');

        fetch(`http://localhost:8080/api/posts/${id}`, request)
            .then((res => {
                console.log(res.status);
                createView("/posts")
            }).catch(error => {
                console.log(error);
                createView("/posts")
            }));

    })
}

export function PostsEvent() {
//call function for create btn listener
    createPost();
    editPost();
    deletePost();
    //call function for edit btn listener
//call function for delete btn listener
}

