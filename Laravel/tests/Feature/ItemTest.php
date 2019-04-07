<?php

namespace Tests\Feature;

use App\Item;
use Tests\TestCase;
use Illuminate\Foundation\Testing\WithoutMiddleware;
use Illuminate\Foundation\Testing\DatabaseMigrations;
use Illuminate\Foundation\Testing\DatabaseTransactions;

class ItemTest extends TestCase
{
    /**
     * A basic test example.
     *
     * @return void
     */
    use DatabaseMigrations;
    
    protected function setUp()
    {
        parent::setUp();
        (new \DatabaseSeeder())->run(); // データ登録
    }
    
    public function testIndex()
    {
        $response = $this->get('\api\items');
        
        $response->assertStatus(200);
        $this->assertCount(1, $response->json());
    }
    
    public function testShow()
    {
        $response = $this->get('\api\items\1');
        
        $response->assertStatus(200);
    }
    
    public function testStore()
    {
        $data = ['content' => 'ブログを書く'];
        $response = $this->post( '\api\items', $data );
        
        $response->assertStatus(201);
        $response->asserJson($data);
        $item = Item::query()->find($response->json()['id']);
        $this->assertInstanceOf(Item::class, $item);
    }
    
    public function testUpdateContent()
    {
        $data = ['content' => 'ブログを書く'];
        $response = $this->patch('\api\items\1', $data );
        
        $response->assertStatus(200);
        $response->asserJson($data);
        $item = Item::query()->find(1);
        $this->assertSame('ブログを書く', $item->content);
    }
    
    public function testUpdateChecked()
    {
        $data = ['checked' => 1];
        $response = $this->patch('\api\items\1', $data);
        
        $response->assertStatus(200);
        $response->assertJson($data);
        $item = Item::query()->find(1);
        $this->asserEquals(true, $item->checked);
    }
    
    public function testDelete()
    {
        $response = $this->delete('\api\items\1');
        
        $response->assertStatus(200);
        $this->asserNull(Item::query()->find(1));
    }
}
